# Keycloak Themes

This project contains the various keycloak themes for our clients and Keycloak instances.  All themes are based on Keycloak 22.0.0.

## Prerequisites

If you want to build your theme for deployment, you will need Apache Ant installed.  If you want to run tests and preview your themes, you will need Apache Maven installed.

## Building the JAR

The jar can be built by running, in the root directory:
`ant`

## Running the Tests

Tests can be run using:
`mvn test`

## Previewing Your Templates

You may preview the rendering of your templates by starting the local server with:
`mvn jetty:run-war`

Your templates can then be previewed at:
`http://localhost:8080/preview/<theme name>/<template name>`

A crash means:
1. Your template has errors.
2. The mock interfaces for the keycloak objects aren't complete yet.

The error message should tell you which.

## Adding a New Theme

TBD
