# notification-service

[![Build Status](https://travis-ci.org/becoming/01-java-notification-service.svg?branch=master)](https://travis-ci.org/becoming/01-java-notification-service)
[![Maintainability](https://api.codeclimate.com/v1/badges/bae2216087d74560df26/maintainability)](https://codeclimate.com/github/becoming/01-java-notification-service/maintainability)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fbecoming%2F01-java-notification-service.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fbecoming%2F01-java-notification-service?ref=badge_shield)
[ ![Download](https://api.bintray.com/packages/becoming/m2/notification-service/images/download.svg) ](https://bintray.com/becoming/m2/notification-service/_latestVersion) 
[![Gitter](https://badges.gitter.im/becoming-tech/community.svg)](https://gitter.im/becoming-tech/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

A service capable of sending notifications. It exposes a REST interface for interaction.
[Official website](https://becoming.tech)

### Learning and Docs

You can proceed on learning the materials from this repository assuming that you know already [0-java-fundamentals](https://github.com/becoming/0-java-fundamentals)

Please refer to the [Wiki section](https://github.com/becoming/notification-service/wiki) of this repository for a complete guide on how to build this application step by step and learn the required technologies along the way.

[YouTube Playlist](https://www.youtube.com/playlist?list=PLPkoWZmDIKwAE9aAHJpwnlwZDwg87mUfl)

### Setup

#### System requirements

 - Java 8
 - Maven 3.x - latest

As well, please install [this software list](https://becoming.tech/java/apps-and-software), to be covered.

#### Compile and build the app

```bash
mvn clean package
```

#### Run

```bash
mvn spring-boot:run
```

### Download a build

You can download a build of this service from our [Bintray repository.](https://bintray.com/beta/#/becoming/m2/)

You can use maven as well by using the instructions from **Set me up** button, (_top right_)


## Self testing

In order to test if you learned well the things so far try to do the following apps:

1. Email notifications via google
    - via dedicated route: /email-google/
1. Email notifications via amazon's  simple email service
    - via dedicated route: /email-amazon-ses/
1. Push notification via Firebase
    - via dedicated route: /push/


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fbecoming%2F01-java-notification-service.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fbecoming%2F01-java-notification-service?ref=badge_large)