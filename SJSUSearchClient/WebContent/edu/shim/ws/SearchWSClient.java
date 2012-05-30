package edu.shim.ws;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import edu.shim.ws.SearchOperationServiceStub.Searchallevents;
import edu.shim.ws.SearchOperationServiceStub.SearchalleventsResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchallmovies;
import edu.shim.ws.SearchOperationServiceStub.SearchallmoviesResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchallnews;
import edu.shim.ws.SearchOperationServiceStub.SearchallnewsResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchrestraunts;
import edu.shim.ws.SearchOperationServiceStub.SearchrestrauntsResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchmovies;
import edu.shim.ws.SearchOperationServiceStub.SearchmoviesResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchevents;
import edu.shim.ws.SearchOperationServiceStub.SearcheventsResponse;
import edu.shim.ws.SearchOperationServiceStub.Searchnews;
import edu.shim.ws.SearchOperationServiceStub.SearchnewsResponse;
public class SearchWSClient 
{
	private static final String SERVICE_END_POINT = 
		"http://localhost:8080/axis2/services/SearchOperationService/";
	private SearchOperationServiceStub stub;
	public SearchWSClient()
	{
		try {
			// CalculatorServiceStub is generated by WSDL2JAVA
			stub = new SearchOperationServiceStub(SERVICE_END_POINT);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String searchrestrauntdisplay(String name)
	{
		Searchrestraunts params=new Searchrestraunts();
		SearchrestrauntsResponse result=new SearchrestrauntsResponse();
		String param=name;
		params.setParam1(param);
		try {
			result = stub.searchrestraunts(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultsearch=result.getSearchrestrauntsresult().toString();
		System.out.println ( "Result   -->" +resultsearch);
		return resultsearch;
	}
	public String searchallrestrauntdisplay()
	{
		Searchrestraunts params=new Searchrestraunts();
		SearchrestrauntsResponse result=new SearchrestrauntsResponse();
		String param="Milpitas";
		params.setParam1(param);
		try {
			result = stub.searchrestraunts(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultsearch=result.getSearchrestrauntsresult().toString();
		System.out.println ( "Result   -->" +resultsearch);
		return resultsearch;
	}
	public String searchmoviedisplay(String name,String myvalue)
	{
		Searchmovies params1=new Searchmovies();
		SearchmoviesResponse result1=new SearchmoviesResponse();
	 
		params1.setParam1(myvalue);
		params1.setParam2(name);
		
		try {
			result1 = stub.searchmovies(params1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String movieresult=result1.getSearchmoviesresult();
		System.out.println ( "Result   -->" + movieresult);
		return movieresult;
	}
	public String searchallmoviedisplay()
	{
		Searchallmovies params1=new Searchallmovies();
		SearchallmoviesResponse result1=new SearchallmoviesResponse();
		String param="San Jose";
		 
	 
		params1.setParam1(param);
		
		try {
			result1 = stub.searchallmovies(params1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String movieresult=result1.getSearchallmoviesresult();
		System.out.println ( "Result   -->" + movieresult);
		return movieresult;
	}
	public String searcheventdisplay(String name)
	{
		Searchevents params=new Searchevents();
		SearcheventsResponse result=new SearcheventsResponse();
		String date=name;
		params.setParam1(date);
		try {
			result = stub.searchevents(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String myresult=result.getSearcheventsresult();
		System.out.println ( "Result   -->" +myresult);
		return myresult;
	}
	public String searchalleventdisplay()
	{
		Searchallevents params=new Searchallevents();
		SearchalleventsResponse result=new SearchalleventsResponse();
		String date="12th April";
		params.setParam1(date);
		try {
			result = stub.searchallevents(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultmy=result.getSearchalleventsresult();
		System.out.println ( "Result   -->" +resultmy);
		return resultmy;
	}
	public String searchnewsdisplay(String name)
	{
		Searchevents params=new Searchevents();
		SearcheventsResponse result=new SearcheventsResponse();
		String date=name;
		params.setParam1(date);
		try {
			result = stub.searchevents(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String myresult=result.getSearcheventsresult();
		System.out.println ( "Result   -->" +myresult);
		return myresult;
	}
	public String searchallnewsdisplay( )
	{
		Searchallnews params=new Searchallnews();
		SearchallnewsResponse result=new SearchallnewsResponse();
		String date="12th April";
		params.setParam1(date);
		try {
			result = stub.searchallnews(params);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newsresult=result.getSearchallnewsresult();
		System.out.println ( "Result   -->" +result.getSearchallnewsresult());
		return newsresult;
	}
	public static void main(String[] args) {
		SearchWSClient sws=new SearchWSClient();
		sws.searchrestrauntdisplay("Milpitas");
		sws.searchmoviedisplay("San Jose","City");
		sws.searcheventdisplay("12th April");
		sws.searchnewsdisplay("12th April");
		sws.searchalleventdisplay();
		sws.searchallmoviedisplay();
		sws.searchallnewsdisplay();
		//sws.searchallrestrauntdisplay("Milpitas");
	 
	}
}