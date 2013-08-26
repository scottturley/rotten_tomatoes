<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Rotten Tomatoes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Scott Turley">

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <!-- 
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
     -->
       <style type="text/css">
    div.new_html_code {
      width:500px;
      height:500px;
      min-width:150px;
      min-height:100px;
      max-width:200px;
      max-height:500px;
      overflow:hidden;
      display:block;
      border:1px solid-red;
      text-align: center;
      img {
      	marging: 0 auto;
      }
    }
  </style>
</head>

<body>

<!--  

		
		for (Movie thisMovie : movieInfo.getMovies())
		{
				writer.println("<img src=" + thisMovie.getPosters().detailed + ">");
				
				if (thisMovie.getRatings() != null)
				{
					writer.println("<H2>Critics Rating = " + thisMovie.getRatings().getCritics_rating() + "</H2>");
					writer.println("<H2>Critics Rating = " + thisMovie.getRatings().getCritics_score() + "</H2>");
					writer.println("<H2>MPAA Rating = " + thisMovie.getMpaa_rating() + "</H2>");
				}
				
				writer.println("<p>" + thisMovie.getCritics_consensus() + "</p>");
				writer.println("<hr>");
		}
	}
-->
<%@ page import="java.util.Iterator" %>
<%@ page import="movieratings.web.Movies.Movie" %>
<jsp:useBean id="movies" scope="request" type="java.util.List" />

<div class="container-fluid">
	<div class="row-fluid">
	<div id="myCarousel" class="carousel span8 offset2 slide">
  		<div class="carousel-inner">
  		<div class="active item">   		
  		<!--  	<div class="thumbnails">-->


 	<% 
	Iterator it = movies.iterator();
	Integer  i  = 0;
 	
	while (it.hasNext())
	{
		if ((i % 1 == 0) && (i != 0))
		{ %>
		<div class="item"> 
	<%	}
         Movie thisMovie = (Movie) it.next(); %>
         		<div class="new_html_code">  
	 				<div class="caption"><h5><%=thisMovie.getTitle() %></h5></div>
	 				<div class="caption"><h5>Rated: <%=thisMovie.getMpaa_rating() %></h5></div>
	 				<div class="caption"><h5><%=thisMovie.getCritics_consensus() %></h5></div>
		 			<div class="caption"><h5>Critics Rating: <%=thisMovie.getRatings().getCritics_rating() %></h5></div>
     				<div class="caption"><h5>Critics Score: <%= thisMovie.getRatings().getCritics_score() %> </h5></div>
 					<img src="<%=thisMovie.getPosters().getDetailed()%>" alt="Image" width="200" height="250" />	
				</div>
	<%  
		i++;
	
		if ((i % 1 == 0) && (i != 0))
		{ 
	%>
		</div>	
	<%
		}	
	}
	%>
		<!--  </div>-->
		</div>	    
    	</div><!--/carousel-inner-->
      
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div><!--/myCarousel-->
	</div>
</div>
<!--  </div>--><!-- container -->

<!-- This is just a little bit of custom CSS code to enhance things. Feel free to place this in your main CSS file. I've commented to say what each bit does. -->
<style type="text/css">
/* Removes the default 20px margin and creates some padding space for the indicators and controls */

    .carousel {
	    margin-bottom: 0;
    	padding: 0 40px 30px 40px;
    }
    
    /* Reposition the controls slightly */
    .carousel-control {
    	left: -12px;
    }
    .carousel-control.right {
   		right: -12px;
    }
    
    /* Changes the position of the indicators */
    .carousel-indicators {
    	right: 50%;
    	top: auto;
    	bottom: 0px;
    	margin-right: -19px;
    }
    /* Changes the colour of the indicators */
    .carousel-indicators li {
    	background: #c0c0c0;
    }
    .carousel-indicators .active {
    	background: #333333;
    }
</style>


    <!-- Call jQuery 1.9, call bootstrap.js and run the carousel when the DOM is ready. Slide every 10 seconds. -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script src="http://code.jquery.com/jquery.js"></script> 
 <!--    
 	<script type="text/javascript">
    $(document).ready(function() {
   		 $('#myCarousel').carousel({
    	interval: 10000
    	})
    });
    </script>
-->
</body>
