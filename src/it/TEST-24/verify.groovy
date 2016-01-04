outputDirectory = new File(basedir, 'project2/target/dependency');
assert outputDirectory.exists();
assert outputDirectory.isDirectory();

generatedJavaFile = new File(outputDirectory, 'test-24-project1-1.0.0.protobin');
assert generatedJavaFile.exists();
assert generatedJavaFile.isFile();

return true;
