package gov.nih.nci.cagrid.protexpress.tutorial;

import java.util.Iterator;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.CQLQueryResultsIterator;


public class QueryRunner {
    private String serviceUrl;
    private String queryFilename;

    public QueryRunner(String serviceUrl, String queryFilename) {
        this.serviceUrl = serviceUrl;
        this.queryFilename = queryFilename;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("USAGE: <serviceUrl> <queryFilename>");
            System.exit(1);
        }
        QueryRunner runner = new QueryRunner(args[0], args[1]);
        runner.performQuery();
    }

    private void performQuery() {
        try {
            // initialize the generic data service client
            DataServiceClient client = new DataServiceClient(serviceUrl);
            // deserialize the CQL query
            CQLQuery query = (CQLQuery) Utils.deserializeDocument(queryFilename, CQLQuery.class);
            // execute the query on the data service
            System.out.println("Querying");
            CQLQueryResults results = client.query(query);
            // create a results iterator
            System.out.println("Iterating");
            Iterator iter = new CQLQueryResultsIterator(results, true);
            // iterate and print XML
            while (iter.hasNext()) {
                String value = (String) iter.next();
                System.out.println("-- RESULT --");
                System.out.println(value);
            }
            System.out.println("Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
