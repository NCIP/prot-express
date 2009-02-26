Java client to test the CaArray GRID API:
-----------------------------------------
1. This test connects to array.nci.nih.gov. (If using a local installation
   of caArray, please set the right grid server name and grid service port
   in build.xml.)
2. All jar dependencies including the caArray client jar are downloadable from
   https://gforge.nci.nih.gov/frs/download.php/3379/caarray_client_2_0_1.zip.
   From this archive, extract the following and put them under the lib/
   directory:
   (a) caarray-client.jar
   (b) lib/
   (c) grid/
3. ant targets:
     clean
     runGridCqlSearch (Runs a simple CQL search using the Grid API)
     runAllGridTests (Runs all tests for the Grid API)
4. The output will appear in the out/ directory.
   Sample output is provided in the out/ directory for a test run.

Note: The output of the tests depends on certain data being available
in the caArray system you are connecting to. Please look at the code
for the individual tests to determine what this data is. Most tests
rely on 4 experiments being present:
   Affymetrix Specification with Data 01
   Affymetrix Experiment with CHP Data 01
   Illumina Rat with Data 01
   Genepix Cow with Data 01

