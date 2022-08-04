# Contributor's Guide

## Code of Conduct

This project and everyone participating in it is governed by the [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code.

## How you can help

  As with any open source project, there are several ways you can help:
  * Submit [bug reports](#reporting-bugs) and feature requests into the issue tracker
  * Submit [patches](#patches) to reported issues (both those you find, or that others have filed)
  * Help with the documentation

## Reporting bugs

  Please provide detailed information about your environment and steps to reproduce the problem.
  Specifically, please include the following:

  * Output of `mvn --version` command:
    * Operating system
    * Maven version
    * Java version
  * Whether you are running Maven inside an IDE, and in that case, which IDE
  * Plugin configuration
  * Any relevant information from the log files

## Patches

  Patches and pull requests are very welcome as long as they adhere to the following simple rules:

  * the existing coding style is preserved;
  * the patch does not needlessly introduce major code refactorings;
  * the patch preserves backwards compatibility;
  * no existing integration tests are broken by the patch;
  * code and site documentation is updated, all new goals and parameters are marked with `@since <version>` tag;
  * javadocs are kept compliant with doclint;
  * ideally, integration tests are provided to cover the changes introduced in the patch.
