outputDirectory = new File(basedir, 'target/generated-resources/protobuf/descriptor-sets');
assert outputDirectory.exists();
assert outputDirectory.isDirectory();

generatedJavaFile = new File(outputDirectory, 'test-15-1.0.0.protobin');
assert generatedJavaFile.exists();
assert generatedJavaFile.isFile();

return true;
