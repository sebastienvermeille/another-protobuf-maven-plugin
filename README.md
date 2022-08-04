[![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://github.com/sebastienvermeille/another-protobuf-maven-plugin/blob/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/dev.cookiecode/protobuf-maven-plugin.svg)](https://mvnrepository.com/artifact/dev.cookiecode/protobuf-maven-plugin/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sebastienvermeille_another-protobuf-maven-plugin&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sebastienvermeille_another-protobuf-maven-plugin)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=sebastienvermeille_another-protobuf-maven-plugin&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=sebastienvermeille_another-protobuf-maven-plugin)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sebastienvermeille_another-protobuf-maven-plugin&metric=coverage)](https://sonarcloud.io/summary/new_code?id=sebastienvermeille_another-protobuf-maven-plugin)

[//]: # ([![Build Status]&#40;https://travis-ci.com/xolstice/protobuf-maven-plugin.svg?branch=master&#41;]&#40;https://travis-ci.com/xolstice/protobuf-maven-plugin&#41;)

[//]: # ([![Build status]&#40;https://ci.appveyor.com/api/projects/status/u8mxkjcs1xl1s3om/branch/master?svg=true&#41;]&#40;https://ci.appveyor.com/project/xolstice/protobuf-maven-plugin/branch/master&#41;)

[//]: # ([![Known Vulnerabilities]&#40;https://snyk.io/test/github/xolstice/protobuf-maven-plugin/badge.svg&#41;]&#40;https://snyk.io/test/github/xolstice/protobuf-maven-plugin&#41;)
[//]: # ([![CII Best Practices]&#40;https://bestpractices.coreinfrastructure.org/projects/4070/badge&#41;]&#40;https://bestpractices.coreinfrastructure.org/projects/4070&#41;)
[//]: # ([![Join the chat at https://gitter.im/xolstice/protobuf-maven-plugin]&#40;https://badges.gitter.im/xolstice/protobuf-maven-plugin.svg&#41;]&#40;https://gitter.im/xolstice/protobuf-maven-plugin?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge&#41;)

# Another Maven Protocol Buffers Plugin

A plugin that integrates protocol buffers compiler (`protoc`) into Maven lifecycle.

[Release notes](https://another-protobuf-maven-plugin.cookiecode.dev/changes-report.html) and detailed documentation
are available on the [web site](https://another-protobuf-maven-plugin.cookiecode.dev/).

Please also read [Contribution Guidelines](docs/CONTRIBUTING.md) and [Code of Conduct](docs/CODE_OF_CONDUCT.md) for this project.


### Why did you create another plugin ?

This is a continuation of `maven-protobuf-plugin` that was forked by xolstice, which was itself a continuation of
`maven-protoc-plugin` that was started at Google and later developed by GitHub community.

I opened a PR years ago as many other contributors but the `maven-protobuf-plugin` project was unfortunately
abandoned by its authors.
