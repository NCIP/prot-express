Java client to test the protExpress Grid API
____________________________________________________________________________________________________________________

1. This test connects to the server and grid server hostnames defined in the "build.properties" file.
2. Default values are provided for running the tests. These values are configurable in the "build.properties" file:
	server.hostname=protexpress.nci.nih.gov
	server.port=28080
	grid.server.hostname=protexpress.nci.nih.gov
	grid.server.port=28080

	experiment.id=1
	experimentrun.id=4
	protocol.id=7
	protocolapplication.id=18
	inputoutputobject.id=34
	contactperson.id=69

3. The tests query each of the present classes for an object with a given Id. If the object is retrieved, all methods
   are invoked, and the values are logged.
4. ant targets:
     clean
     echo_properties (Echoes the test environment property values).
     runGridTests (Runs all tests for the Grid API)
5. The output will appear in the out/ directory. Sample output is provided in the out/ directory for a test run, with the
   default values specified in "build.properties" file.

Note: The output of the tests depends on certain data being available in the protExpress system you are connecting to.
Please ensure that correct id's for experiment, protocol and other objects are specified.



