package edu.shim.ws;
import java.util.ArrayList;
import java.util.Iterator;

import edu.shim.www.searchoperationservice.Searchallevents;
import edu.shim.www.searchoperationservice.SearchalleventsResponse;
import edu.shim.www.searchoperationservice.Searchallmovies;
import edu.shim.www.searchoperationservice.SearchallmoviesResponse;
import edu.shim.www.searchoperationservice.Searchallnews;
import edu.shim.www.searchoperationservice.SearchallnewsResponse;
import edu.shim.www.searchoperationservice.Searchallrestraunts;
import edu.shim.www.searchoperationservice.SearchallrestrauntsResponse;
import edu.shim.www.searchoperationservice.Searchevents;
import edu.shim.www.searchoperationservice.SearcheventsResponse;
import edu.shim.www.searchoperationservice.Searchmovies;
import edu.shim.www.searchoperationservice.SearchmoviesResponse;
import edu.shim.www.searchoperationservice.Searchnews;
import edu.shim.www.searchoperationservice.SearchnewsResponse;
import edu.shim.www.searchoperationservice.Searchrestraunts;
import edu.shim.www.searchoperationservice.SearchrestrauntsResponse;
import me.prettyprint.cassandra.model.IndexedSlicesQuery;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.QueryResult;
public class SearchOperationService implements SearchOperationServiceSkeletonInterface
{
private static StringSerializer stringSerializer = StringSerializer.get();
	 
@Override
public SearchrestrauntsResponse searchrestraunts(Searchrestraunts searchrestraunts) 
{
SearchrestrauntsResponse last_key = new SearchrestrauntsResponse();
ArrayList<String> al = new ArrayList<String>(); 
String searchresult=null;
String zip=searchrestraunts.getParam1();
String Address=null;
String Phone=null;
String lat=null;
String lon=null;
System.out.println(zip);
//Create a cluster object from your existing Cassandra cluster
 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
 //Create a keyspace object from the existing keyspace we created using CLI
Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
isq.addEqualsExpression("Name",zip);
isq.setColumnNames("Address","Name","Zip","Phone","lat","lon");
isq.setColumnFamily("restraunts");
QueryResult<OrderedRows<String, String, String>> result = isq.execute();
isq.setStartKey("");
OrderedRows<String, String, String> rows = result.get();
System.out.println("here");
Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
while (rowsIterator.hasNext()) 
        {
            Row<String, String, String> row = rowsIterator.next();
            String row1=row.getKey();
            String City=row.getColumnSlice().getColumnByName("Name").getValue();
            Address=row.getColumnSlice().getColumnByName("Address").getValue();
            Phone=row.getColumnSlice().getColumnByName("Phone").getValue();
            lat=row.getColumnSlice().getColumnByName("lat").getValue();
            lon=row.getColumnSlice().getColumnByName("lon").getValue();
            searchresult=row1+", "+City+", "+Address+", ("+lat+", "+lon+")\n";
            al.add(searchresult);
            for(int i=0;i<al.size();i++){
            last_key.setSearchrestrauntsresult(al.toString()+"\n");
            System.out.println("here");
            }    
            //last_key.setSearchresponseresult(searchresult);
        }
        return last_key;
	}
@Override
public SearchallrestrauntsResponse searchallrestraunts(
		Searchallrestraunts searchallrestraunts) 
{
	SearchallrestrauntsResponse last_key = new SearchallrestrauntsResponse();
	ArrayList<String> al = new ArrayList<String>(); 
	String searchresult=null;
	String zip=searchallrestraunts.getParam1();
	String Address=null;
	String Phone=null;
	String lat=null;
	String lon=null;
	System.out.println(zip);
	//Create a cluster object from your existing Cassandra cluster
	 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
	 //Create a keyspace object from the existing keyspace we created using CLI
	Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
	IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
	isq.addEqualsExpression("Zip","95113");
	isq.setColumnNames("Address","Name","Zip","Phone","lat","lon");
	isq.setColumnFamily("restraunts");
	QueryResult<OrderedRows<String, String, String>> result = isq.execute();
	isq.setStartKey("");
	OrderedRows<String, String, String> rows = result.get();
	System.out.println("here");
	Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
	while (rowsIterator.hasNext()) 
	        {
	            Row<String, String, String> row = rowsIterator.next();
	            String row1=row.getKey();
	            String City=row.getColumnSlice().getColumnByName("Name").getValue();
	            Address=row.getColumnSlice().getColumnByName("Address").getValue();
	            Phone=row.getColumnSlice().getColumnByName("Phone").getValue();
	            lat=row.getColumnSlice().getColumnByName("lat").getValue();
	            lon=row.getColumnSlice().getColumnByName("lon").getValue();
	            searchresult=row1+", "+City+", "+Address+", "+Phone+"\n";
	            al.add(searchresult);
	            for(int i=0;i<al.size();i++)
	            {
	            last_key.setSearchallrestrauntsresult(al.toString()+"\n");
	            System.out.println("here");
	            }    
	            //last_key.setSearchresponseresult(searchresult);
	        }
	        return last_key;
}
@Override
public SearcheventsResponse searchevents(Searchevents searchevents) 
{
	SearcheventsResponse last_key = new SearcheventsResponse();
	ArrayList<String> al = new ArrayList<String>(); 
	String searchresult=null;
	String date=searchevents.getParam1();
	String Address=null;
	String Phone=null;
	System.out.println(date);
	//Create a cluster object from your existing Cassandra cluster
	 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
	 //Create a keyspace object from the existing keyspace we created using CLI
	Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
	IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
	isq.addEqualsExpression("Place",date);
	isq.setColumnNames("Address","Day","Time","Zip");
	isq.setColumnFamily("events");
	QueryResult<OrderedRows<String, String, String>> result = isq.execute();
	isq.setStartKey("");
	OrderedRows<String, String, String> rows = result.get();
	System.out.println("here");
	Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
	while (rowsIterator.hasNext()) 
	        {
	            Row<String, String, String> row = rowsIterator.next();
	            String row1=row.getKey();
	            String Event=row.getColumnSlice().getColumnByName("Address").getValue();
	            String Date=row.getColumnSlice().getColumnByName("Zip").getValue();
	            String Time=row.getColumnSlice().getColumnByName("Time").getValue();
	            String Day=row.getColumnSlice().getColumnByName("Day").getValue();
	            searchresult=Event+", "+Date+", "+Time+", "+Day+"\n";
	            al.add(searchresult);
	            for(int i=0;i<al.size();i++)
	            {
	            last_key.setSearcheventsresult(al.toString()+"\n");
	            System.out.println("here");
	            }    
	            //last_key.setSearchresponseresult(searchresult);
	        }
	        return last_key;
     	 
}
@Override
public SearchalleventsResponse searchallevents(Searchallevents searchallevents) {
	SearchalleventsResponse last_key = new SearchalleventsResponse();
	ArrayList<String> al = new ArrayList<String>(); 
	String searchresult=null;
	String date=searchallevents.getParam1();
	String Address=null;
	String Phone=null;
	System.out.println(date);
	//Create a cluster object from your existing Cassandra cluster
	 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
	 //Create a keyspace object from the existing keyspace we created using CLI
	Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
	IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
	isq.addEqualsExpression("Zip","95113");
	isq.setColumnNames("Address","Zip","Time","Day");
	isq.setColumnFamily("events");
	QueryResult<OrderedRows<String, String, String>> result = isq.execute();
	isq.setStartKey("");
	OrderedRows<String, String, String> rows = result.get();
	System.out.println("here");
	Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
	while (rowsIterator.hasNext()) 
	        {
	            Row<String, String, String> row = rowsIterator.next();
	            String row1=row.getKey();
	            String Event=row.getColumnSlice().getColumnByName("Address").getValue();
	            String Date=row.getColumnSlice().getColumnByName("Zip").getValue();
	            String Time=row.getColumnSlice().getColumnByName("Time").getValue();
	            String Day=row.getColumnSlice().getColumnByName("Day").getValue();
	            searchresult=Event+", "+Date+", "+Time+", "+Day+"\n";
	            al.add(searchresult);
	            for(int i=0;i<al.size();i++)
	            {
	            last_key.setSearchalleventsresult(al.toString()+"\n");
	            System.out.println("here");
	            }    
	            //last_key.setSearchresponseresult(searchresult);
	        }
	        return last_key;
     	 
}

@Override
public SearchmoviesResponse searchmovies(Searchmovies searchmovies) 
 {
     		SearchmoviesResponse last_key = new SearchmoviesResponse();
     		ArrayList<String> al = new ArrayList<String>(); 
     		 
     		String value=searchmovies.getParam1();
     		String name=searchmovies.getParam2();
     		 
     		System.out.println(name);
     		//Create a cluster object from your existing Cassandra cluster
     		 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
     		 //Create a keyspace object from the existing keyspace we created using CLI
     		Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
     		IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
     		isq.setColumnFamily("movies");
     		isq.addEqualsExpression(value,name);
     		isq.setColumnNames("Address","Phone","Zip","Name","Theatre","Time");
     		
     		QueryResult<OrderedRows<String, String, String>> result = isq.execute();
     		isq.setStartKey("");
     		OrderedRows<String, String, String> rows = result.get();
     		System.out.println("here");
     		Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
     		while (rowsIterator.hasNext()) 
     		        {
     		            Row<String, String, String> row = rowsIterator.next();
     		            String row1=row.getKey();
     		            String Address=row.getColumnSlice().getColumnByName("Address").getValue();
     		            String Name=row.getColumnSlice().getColumnByName("Name").getValue();
     		            String Phone=row.getColumnSlice().getColumnByName("Phone").getValue();
     		            String Theatre=row.getColumnSlice().getColumnByName("Theatre").getValue();
     		           String Time=row.getColumnSlice().getColumnByName("Time").getValue();
     		            String Zip=row.getColumnSlice().getColumnByName("Zip").getValue();
     		            String searchresult=Name+", "+Theatre+", "+Address+", "+Zip+", "+Phone+", "+Time+"\n";
     		            al.add(searchresult);
     		            for(int i=0;i<al.size();i++)
     		            {
     		            last_key.setSearchmoviesresult(al.toString()+"\n");
     		            System.out.println("here");
     		            }    
     		            //last_key.setSearchresponseresult(searchresult);
     		        }
     		        return last_key;
     	}
@Override
public SearchallmoviesResponse searchallmovies(Searchallmovies searchallmovies) {
	SearchallmoviesResponse last_key = new SearchallmoviesResponse();
		ArrayList<String> al = new ArrayList<String>(); 
		 
		String name=searchallmovies.getParam1();
		 
		System.out.println(name);
		//Create a cluster object from your existing Cassandra cluster
		 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
		 //Create a keyspace object from the existing keyspace we created using CLI
		Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
		IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
		isq.setColumnFamily("movies");
		isq.addEqualsExpression("Zip","95113");
		isq.setColumnNames("Address","Phone","Zip","Name","Theatre","Time");
		
		QueryResult<OrderedRows<String, String, String>> result = isq.execute();
		isq.setStartKey("");
		OrderedRows<String, String, String> rows = result.get();
		System.out.println("here");
		Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
		while (rowsIterator.hasNext()) 
		        {
		            Row<String, String, String> row = rowsIterator.next();
		            String row1=row.getKey();
		            String Address=row.getColumnSlice().getColumnByName("Address").getValue();
		            String City=row.getColumnSlice().getColumnByName("Name").getValue();
		            String Phone=row.getColumnSlice().getColumnByName("Phone").getValue();
		            String Theatre=row.getColumnSlice().getColumnByName("Theatre").getValue();
		            String Time=row.getColumnSlice().getColumnByName("Time").getValue();
		            String Zip=row.getColumnSlice().getColumnByName("Zip").getValue();
		            String searchresult=City+", "+Theatre+", "+Address+", "+Zip+", "+Phone+", "+Time+"\n";
		            al.add(searchresult);
		            for(int i=0;i<al.size();i++)
		            {
		            last_key.setSearchallmoviesresult(al.toString()+"\n");
		            System.out.println("here");
		            }    
		            //last_key.setSearchresponseresult(searchresult);
		        }
		        return last_key;
	}
     	@Override
     	public SearchnewsResponse searchnews(Searchnews searchnews)
     	{
     		SearchnewsResponse last_key = new SearchnewsResponse();
     		ArrayList<String> al = new ArrayList<String>(); 
     		 
     		String date=searchnews.getParam1();
     		 
     		System.out.println(date);
     		//Create a cluster object from your existing Cassandra cluster
     		 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
     		 //Create a keyspace object from the existing keyspace we created using CLI
     		Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
     		IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
     		isq.addEqualsExpression("Date",date);
     		isq.setColumnNames("Date","Day","News","Time");
     		isq.setColumnFamily("news");
     		QueryResult<OrderedRows<String, String, String>> result = isq.execute();
     		isq.setStartKey("");
     		OrderedRows<String, String, String> rows = result.get();
     		System.out.println("here");
     		Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
     		while (rowsIterator.hasNext()) 
     		        {
     		            Row<String, String, String> row = rowsIterator.next();
     		            String row1=row.getKey();
     		            String Event=row.getColumnSlice().getColumnByName("News").getValue();
     		            String Date=row.getColumnSlice().getColumnByName("Date").getValue();
     		            String Time=row.getColumnSlice().getColumnByName("Time").getValue();
     		            String Day=row.getColumnSlice().getColumnByName("Day").getValue();
     		            String searchresult=Event+", "+Date+", "+Time+", "+Day+"\n";
     		            al.add(searchresult);
     		            for(int i=0;i<al.size();i++)
     		            {
     		            last_key.setSearchnewsresult(al.toString()+"\n");
     		            System.out.println("here");
     		            }    
     		            //last_key.setSearchresponseresult(searchresult);
     		        }
     		        return last_key;
     	}
     	@Override
     	public SearchallnewsResponse searchallnews(Searchallnews searchallnews) {
     		SearchallnewsResponse last_key = new SearchallnewsResponse();
     			ArrayList<String> al = new ArrayList<String>(); 
     			 
     			String date=searchallnews.getParam1();
     			 
     			System.out.println(date);
     			//Create a cluster object from your existing Cassandra cluster
     			 Cluster cluster = HFactory.getOrCreateCluster("Test Cluster", "localhost:9160");
     			 //Create a keyspace object from the existing keyspace we created using CLI
     			Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
     			IndexedSlicesQuery<String, String, String> isq = HFactory.createIndexedSlicesQuery(keyspace, stringSerializer, stringSerializer, stringSerializer);
     			isq.addEqualsExpression("Date",date);
     			isq.setColumnNames("Date","Day","News","Time");
     			isq.setColumnFamily("news");
     			QueryResult<OrderedRows<String, String, String>> result = isq.execute();
     			isq.setStartKey("");
     			OrderedRows<String, String, String> rows = result.get();
     			System.out.println("here");
     			Iterator<Row<String, String, String>> rowsIterator =rows.iterator();
     			while (rowsIterator.hasNext()) 
     			        {
     			            Row<String, String, String> row = rowsIterator.next();
     			            String row1=row.getKey();
     			            String Event=row.getColumnSlice().getColumnByName("News").getValue();
     			            String Date=row.getColumnSlice().getColumnByName("Date").getValue();
     			            String Time=row.getColumnSlice().getColumnByName("Time").getValue();
     			            String Day=row.getColumnSlice().getColumnByName("Day").getValue();
     			            String searchresult=Event+", "+Date+", "+Time+", "+Day+"\n";
     			            al.add(searchresult);
     			            for(int i=0;i<al.size();i++)
     			            {
     			            last_key.setSearchallnewsresult(al.toString()+"\n");
     			            System.out.println("here");
     			            }    
     			            //last_key.setSearchresponseresult(searchresult);
     			        }
     			        return last_key;
     		}
	

public static void main(String args[])
{
	SearchOperationService s1=new SearchOperationService();
	//Search for a particular restraunt based on name
	System.out.println("****************");
	String city="threeDegrees";
    Searchrestraunts sc=new  Searchrestraunts();
    sc.setParam1(city);
    SearchrestrauntsResponse c=new  SearchrestrauntsResponse();
    c=s1.searchrestraunts(sc);
    System.out.println(c.getSearchrestrauntsresult()); 
 //Search for all restraunts based on zip
    System.out.println("****************");
	String myzip="95113";
    Searchallrestraunts sa=new  Searchallrestraunts();
    sa.setParam1(myzip);
    SearchallrestrauntsResponse a=new  SearchallrestrauntsResponse();
    a=s1.searchallrestraunts(sa);
    System.out.println(a.getSearchallrestrauntsresult()); 
    //Search for a movie based on movie name or theatre name
    System.out.println("********************************************");
    String name="Lockout";
	String value="Name";
    Searchmovies sm=new  Searchmovies();
    sm.setParam1(value);
    sm.setParam2(name);
    SearchmoviesResponse m=new  SearchmoviesResponse();
    m=s1.searchmovies(sm);
    System.out.println(m.getSearchmoviesresult()); 
    //Search for all movies based on zip
    System.out.println("********************************************");
    String zipname="95113";
	Searchallmovies sam=new  Searchallmovies();
    sam.setParam1(zipname);
    SearchallmoviesResponse am=new  SearchallmoviesResponse();
    am=s1.searchallmovies(sam);
    System.out.println(am.getSearchallmoviesresult()); 
    //Search for news based on date
    System.out.println("********************************************");
    String day="04/23/2012";
    Searchnews sn=new  Searchnews();
    sn.setParam1(day);
    SearchnewsResponse n=new  SearchnewsResponse();
    n=s1.searchnews(sn);
    System.out.println(n.getSearchnewsresult()); 
    //Search for news based on current date
    System.out.println("********************************************");
    String myday="04/25/2012";
    Searchallnews san=new  Searchallnews();
    san.setParam1(myday);
    SearchallnewsResponse an=new  SearchallnewsResponse();
    an=s1.searchallnews(san);
    System.out.println(an.getSearchallnewsresult()); 
    //Search events based on a particular date
    System.out.println("********************************************");
    String date="HP Pavilion";
    Searchevents se=new Searchevents();
    se.setParam1(date);
    SearcheventsResponse e=new  SearcheventsResponse();
    e=s1.searchevents(se);
    System.out.println(e.getSearcheventsresult()); 
  //Search allevents based on a particular date
    System.out.println("********************************************");
    String mydate="HP Pavilion";
    Searchallevents mse=new Searchallevents();
    mse.setParam1(mydate);
    SearchalleventsResponse me=new  SearchalleventsResponse();
    me=s1.searchallevents(mse);
    System.out.println(me.getSearchalleventsresult()); 
 
 
	
}
	  	// TODO Auto-generated method stub









		 
	}


