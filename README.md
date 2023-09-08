[![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://github.com/sebastienvermeille/another-protobuf-maven-plugin/blob/master/LICENSE)
[![join discord](https://img.shields.io/badge/join%20discord-gray?style=flat&logo=discord&link=https://discord.gg/uqQ2SWCQCb)](https://discord.gg/uqQ2SWCQCb)
[![Maven Central](https://img.shields.io/maven-central/v/dev.cookiecode/another-protobuf-maven-plugin.svg)](https://mvnrepository.com/artifact/dev.cookiecode/another-protobuf-maven-plugin/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=dev.cookiecode%3Aanother-protobuf-maven-plugin&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=dev.cookiecode%3Aanother-protobuf-maven-plugin)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=dev.cookiecode%3Aanother-protobuf-maven-plugin&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=dev.cookiecode%3Aanother-protobuf-maven-plugin)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=dev.cookiecode%3Aanother-protobuf-maven-plugin&metric=coverage)](https://sonarcloud.io/summary/new_code?id=dev.cookiecode%3Aanother-protobuf-maven-plugin)

[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/6337/badge)](https://bestpractices.coreinfrastructure.org/projects/6337)


# Another Maven Protocol Buffers Plugin

```
<dependency>
  <groupId>dev.cookiecode</groupId>
  <artifactId>another-protobuf-maven-plugin</artifactId>
  <version>2.1.0</version>
</dependency>
```

A plugin that integrates protocol buffers compiler (`protoc`) into Maven lifecycle.

[Release notes](https://another-protobuf-maven-plugin.cookiecode.dev/changes-report.html) and detailed documentation
are available on the [web site](https://another-protobuf-maven-plugin.cookiecode.dev/).

Please also read [Contribution Guidelines](docs/CONTRIBUTING.md) and [Code of Conduct](docs/CODE_OF_CONDUCT.md) for this project.


### Why did you create another plugin ?

This is a continuation of `maven-protobuf-plugin` that was forked by xolstice, which was itself a continuation of
`maven-protoc-plugin` that was started at Google and later developed by GitHub community.

I opened a PR years ago as many other contributors but the `maven-protobuf-plugin` project was unfortunately
abandoned by its authors.
