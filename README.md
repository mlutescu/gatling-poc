* Introduction

This project demonstrates how  
Gatling Private Locations might be configured, in 3 different ways.

There are 3 sup-projects, each one demonstrating a configuration.

```
    | Supproject | Control Plane configuration | Private Location | tool           |
    |------------+-----------------------------+------------------+----------------|
    | docker-aws | docker                      | aws              | docker-compose |
    | k8s-aws    | kubernetes                  | aws              | helm           |
    | k8s-k8s    | kubernetes                  | kubernetes       | helm           |
```

Instructions to install, see status, uninstall, in each subproject's README.md

* Passing secrets to AWS

Projects _docker-aws_ and _k8s-aws_ demonstrate 
two different ways to inject aws credentials into the control-plane.

Each of these projects has a 'secrets' file with extension `sample`.
For the example to work, you have to edit with those file with actual
values for the secrets, and remove the 'sample' extension:

```
  | subproject | method                                 | `secrets` file                 |
  |------------+----------------------------------------+--------------------------------|
  | docker-aws | mount file /app/.aws/credentials       | aws_credentials.private.sample |
  | k8s-aws    | environment variables with k8s secrets | secrets.sh.sample              |
```
  

* Passing configuration to K8s Control Plane

Projects _k8s-aws_ and _k8s-k8s_ demonstrate 
two different ways to configure the control plane.

Both projects use helm chart wich uses  _gatlingcorp/enterprise-locations-packages_
as a subchart.
Both projects override the named template _configFileContent_ 
defined in the subchart, in helper file _templates/\_config.tpl_.
(This can be done as named templates share a global space, in Helm)

```
 | subproject | method                                                                                |
 |------------+---------------------------------------------------------------------------------------|
 | k8s-aws    | the  _configFileContent_ named template dumps (as prettified json) the values defined |
 |            | as the 'values' of the subchart                                                       |
 | k8s-k8s    | a gradle `preprocess` is used to render _configFileContent_ from input files          |
 |            | control-plane.conf and json.job                                                       |
```





