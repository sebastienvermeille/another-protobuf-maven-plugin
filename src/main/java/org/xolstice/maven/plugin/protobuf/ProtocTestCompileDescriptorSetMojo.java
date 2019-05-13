package org.xolstice.maven.plugin.protobuf;

/*
 * Copyright (c) 2019 Maven Protocol Buffers Plugin Authors. All rights reserved.
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

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;

/**
 * This mojo executes {@code protoc} compiler for generating descriptor sets
 * from test protocol buffer definitions. It also searches dependency artifacts for
 * {@code .proto} files and includes them in the {@code proto_path} so that they can be
 * referenced. Finally, it adds the {@code .proto} files to the project as test resources so
 * that they can be included in the test-jar artifact. The generated descriptor set can be
 * optionally also attached to the project.
 *
 * @since 0.7.0
 */
@Mojo(
        name = "test-compile-descriptor-set",
        defaultPhase = LifecyclePhase.GENERATE_TEST_RESOURCES,
        requiresDependencyResolution = ResolutionScope.TEST,
        threadSafe = true
)
public final class ProtocTestCompileDescriptorSetMojo extends AbstractProtocTestCompileMojo {

    /**
     * This is the directory into which the descriptor set file will be created.
     */
    @Parameter(
            required = true,
            property = "descriptorSetTestOutputDirectory",
            defaultValue = "${project.build.directory}/generated-test-resources/protobuf/descriptor-sets"
    )
    private File outputDirectory;

    /**
     * The descriptor set file name.
     */
    @Parameter(
            required = true,
            defaultValue = "${project.build.finalName}.pb"
    )
    protected String descriptorSetFileName;

    /**
     * If set to {@code true}, the generated descriptor set will be attached to the build.
     */
    @Parameter(
            required = true,
            defaultValue = "false"
    )
    protected boolean attach;

    /**
     * If generated descriptor set is to be attached to the build, specifies an optional classifier.
     */
    @Parameter(
            required = false,
            defaultValue = "test"
    )
    protected String classifier;

    /**
     * If {@code true}, the compiler will include all dependencies in the descriptor set, making it self-contained.
     */
    @Parameter(
            required = false,
            defaultValue = "false"
    )
    protected boolean includeImports;

    /**
     * If {@code true}, do not strip {@code SourceCodeInfo} from the {@code FileDescriptorProto}.
     * This results in significantly larger descriptors that include information about the original location
     * of each declaration in the source file, as well as surrounding comments.
     */
    @Parameter(
            required = false,
            defaultValue = "false"
    )
    protected boolean includeSourceInfo;

    @Override
    protected void addProtocBuilderParameters(final Protoc.Builder protocBuilder) {
        super.addProtocBuilderParameters(protocBuilder);
        final File descriptorSetFile = new File(getOutputDirectory(), descriptorSetFileName);
        getLog().info("Will generate descriptor set:");
        getLog().info(" " + descriptorSetFile.getAbsolutePath());
        protocBuilder.withDescriptorSetFile(descriptorSetFile, includeImports, includeSourceInfo);
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

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    protected void doAttachGeneratedFiles() {
        final File outputDirectory = getOutputDirectory();
        if (attach) {
            final File descriptorSetFile = new File(getOutputDirectory(), descriptorSetFileName);
            projectHelper.attachArtifact(project, "test-pb", classifier, descriptorSetFile);
        }
        buildContext.refresh(outputDirectory);
    }
}
