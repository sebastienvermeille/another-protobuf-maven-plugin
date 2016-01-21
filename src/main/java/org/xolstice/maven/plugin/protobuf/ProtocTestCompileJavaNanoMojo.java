package org.xolstice.maven.plugin.protobuf;

/*
 * Copyright (c) 2016 Maven Protocol Buffers Plugin Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;

/**
 * This mojo executes the {@code protoc} compiler for generating test JavaNano sources
 * from protocol buffer definitions. It also searches dependency artifacts in the test scope for
 * {@code .proto} files and includes them in the {@code proto_path} so that they can be
 * referenced. Finally, it adds the {@code .proto} files to the project as test resources so
 * that they can be included in the test-jar artifact.
 *
 * @since 0.4.3
 */
@Mojo(
        name = "test-compile-javanano",
        defaultPhase = LifecyclePhase.GENERATE_TEST_SOURCES,
        requiresDependencyResolution = ResolutionScope.TEST,
        threadSafe = true
)
public final class ProtocTestCompileJavaNanoMojo extends AbstractProtocTestCompileMojo {

    /**
     * This is the directory into which the {@code .java} test sources will be created.
     */
    @Parameter(
            required = true,
            defaultValue = "${project.build.directory}/generated-test-sources/protobuf/javanano"
    )
    private File outputDirectory;

    /**
     * Additional comma-separated options to be passed to the JavaNano generator.
     * <b>Cannot</b> contain colon (<tt>:</tt>) symbols.
     */
    @Parameter(
            required = false,
            property = "javaNanoOptions"
    )
    private String javaNanoOptions;

    @Override
    protected void addProtocBuilderParameters(final Protoc.Builder protocBuilder) throws MojoExecutionException {
        super.addProtocBuilderParameters(protocBuilder);
        if (javaNanoOptions != null) {
            protocBuilder.setNativePluginParameter(javaNanoOptions);
        }
        protocBuilder.setJavaNanoOutputDirectory(getOutputDirectory());
        // We need to add project output directory to the protobuf import paths,
        // in case test protobuf definitions extend or depend on production ones
        final File buildOutputDirectory = new File(project.getBuild().getOutputDirectory());
        if (buildOutputDirectory.exists()) {
            protocBuilder.addProtoPathElement(buildOutputDirectory);
        }
    }

    @Override
    protected File getOutputDirectory() {
        return outputDirectory;
    }
}
