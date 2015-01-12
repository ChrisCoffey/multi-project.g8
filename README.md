# Ragnar Context Templates

This is a Giter8 project template for an arbitrary Ragnar bounded context. Each bounded context is composed of 4 sub projects like this with several optional sub-projects beneath persistence:

- Context
	- /Core
	- /Protocol
	- /Biz
	- /Transport
	- /Persistence 
		- ? MySql
		- Kafka
		- ? Solr

This structure ensures each contxt in Ragnar is actual it's own complete program capable of receiving Http requests while backed by a persistence layer. The packaging around a given context allows it to be distributed independently or rolled up into a super-project for distribution. 

## Before we start

- You need [git](http://git-scm.com)
- You need [giter8](https://github.com/n8han/giter8)
- You need [SBT](http://scala-sbt.org)

Everything can be installed with brew

## Procedure

1. Clone this _giter8_ template

	$ g8 leafme/ragnar_context
        package [com.domain]: me.leaf.ragnar
        name [Ragnar Context]: ordering 
	context [My Sample Context]: ordering
        
        Template applied in ./ordering

1. Change into the new project directory

        $ cd ./ordering

1. Check out the new project & ensure it matches the structure above. You can find the build definition in `project/Build.scala`

1. Start it up

	$ sbt
	projects
	package

1. Notice how nothing happens! It's up to you to implement the features you need, this is just an empty project structure.


