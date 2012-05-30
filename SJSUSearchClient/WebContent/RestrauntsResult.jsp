<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Restraunts Search Result</title>
	<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="print.css" media="print" />
	 
</head>
<script type="text/javascript"  >
 

function validate()
{
var x=document.forms["myform"]["location"].value;
if (x==null || x=="")
  {
  alert("This field cannot be empty");
  return false;
  }
  else
  {
  return true;
  }
}

</script>
<body>
<div id="wrapper"><!-- #wrapper -->

	<nav><!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="homepage.jsp">Home</a></li>
				<li><a href="restraunts.jsp">Restraunts</a></li>
				<li><a href="movies.jsp">Movies</a></li>
				<li><a href="news.jsp">News</a></li>
				<li><a href="events.jsp">Events</a></li>
				 
			</ul>
		</div>
	</nav><!-- end of top nav -->

	<header><!-- header -->
		<h1> SJSU Search</h1>
	</header><!-- end of header -->

		<div class="clearall"></div>
	
	<section id="main"><!-- #main content -->

	 
			<div id="search_container">
			
				<fieldset id="search_box">
					 
						<p id="search_mat">
						 <form name="locate" method="post" action="map.jsp">
							<center><label for "search_box" id="search_label"><h1>Your Result:
							<%String result=(String)session.getAttribute("myresult");%>
								<h1><%=result%>
												</h1>
											
								<input type="submit" value="location" />
								  
										</h1>
										</label>
										<br> 
									 
								 </form>	 
						  
						  	 
						</p>
				</fieldset>
				<br></br>
				<br></br>
				 
			</div>
		 

		<div class="clearall"></div>
	
		<article id="infoboxleft"> 
			 <img src="images/theatre.jpg" alt="" class="alignleft" />
		</article> 

		<article id="infoboxmid"> 
			  <img src="images/news2.png" alt="" class="alignleft" />
		</article> 

		<article id="infoboxright"> 
			 <img src="images/restaurant.jpg" alt="" class="alignleft" />
		</article>

		 
						
</section><!-- end of #main content -->

		<footer>
				<br />
				 
				<br />
	</footer>

</div><!-- #wrapper -->
 <div onload="initialize()"><div id="map_canvas" style="width:50%; height:50%"></div></div>
</body>
</html>
