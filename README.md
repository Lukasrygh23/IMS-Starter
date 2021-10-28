Coverage: 34%
# Project Title

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Java 1.7
MySQL Server (8.0 Community Edition)
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

In order to have the system functioning you must first install MySQL 8.0 and ensure the server is running (using windows task manager). It can be found under services as:

```
MySQL80
```

If it is already running, you only need to run the program as a java .jar FROM WITHIN TERMINAL.

Doing so by double-clicking it will simply generate an error.txt file with the opening commands inside. As it is a terminal-based application, you must have powershell and have configured java's PATH variable to run the program correctly.

## Running the tests

All tests can be run from within eclipse or your IDE of choice, and are stored in /src/test alongside the main code in src/main/. No database environment is needed for the tests, as they operate on their own temporarily created database that is entirely separate from the main one.

### Unit Tests 

The tests test all methods outside of IMS.java and Runner.java, ensuring that every method runs successfully in the case of both correct and incorrect data.

```
They can be run using JUnit 4, and are stored alongside an alternative test SQL Schema in src/test/
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use Git for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

* **Lukas Rygh** - *Everything else* - [lukasrygh](https://github.com/Lukasrygh23)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgments

* Thanks to Kieran Goodison and Fraser Smith for providing someone useful to talk to during the project, and to Jordan Benbelaid for answering my questions throughout. 