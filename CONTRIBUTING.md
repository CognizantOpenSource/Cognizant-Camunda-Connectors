# Contributing to Cognizant Camunda Connectors [2023]

These are just guidelines, not rules. Use your best judgment. Please feel free to propose changes to this document in a pull request.

## Code of Conduct

This project adheres to the Contributor Covenant [code of conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior to [CamundaComms@cognizant.com](mailto:CamundaComms@cognizant.com), [IPMOSBPMTeam@cognizant.com] (mailto:IPMOSBPMTeam@cognizant.com).



### Reporting Bugs

* Please go through the Help section to see if the problem is already addressed. Most common problems are already addressed in Troubleshooting and FAQs sections.

* Perform a cursory search to see if the problem has already been reported. If it has, add a comment to the existing issue instead of opening a new one.

* Use a clear and descriptive title for the issue to identify the problem.

* Describe your environment - OS Version, Java version, Browsers used and their versions etc.

* Describe the behavior you observed after following the steps and point out what exactly is the problem with that behavior.

* Do check if it is an issue with the third party libraries used. For example Web-Execution and Element Finding issues could be mostly related to Selenium. We will not be able to support issues related to third party libraries.

* If the issues are related to execution attach the `console.txt` and reports if possible.

* If you are facing any issue with the UI attach screenshots and `log.txt` present in the installation location.

* Please report Addon/Extension related issues to their respective Github Repos.


### Suggesting Enhancements

* Perform a cursory search to see if the enhancement has already been suggested. If it has, add a comment to the existing issue instead of opening a new one.

* Use a clear and descriptive title for the issue to identify the suggestion

* Explain why this enhancement would be useful to most Cognizant Intelligent Test Scripter users and isn't something that can or should be implemented as a community package

### Code Contribution

[JAVA 21](https://www.oracle.com/java/technologies/downloads/#java21)

[Maven 3.8](http://maven.apache.org/download.cgi) or greater

Any Java IDE of your choice. We have used Eclipse for development

Setup the dependencies 

``` bash
mvn clean install
```


### Submiting Changes

Always write a clear log message for your commits. One-line messages are fine for small changes, but bigger changes should look like this:

```
$ git commit -m "A brief summary of the commit
> 
> A paragraph describing what changed and its impact."
```


