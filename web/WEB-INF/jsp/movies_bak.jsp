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

<div class="well">
    
<div id="myCarousel" class="carousel slide">

    <ol class="carousel-indicators">
    	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
   		<li data-target="#myCarousel" data-slide-to="1"></li>
    	<li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
 
     <!-- Carousel items -->
    <div class="carousel-inner">
    
    <div class="item active">
   		<div class="row-fluid">   
 	
 	<% 
	Iterator it = movies.iterator();
	Integer  i  = 0;
 	
	while (it.hasNext())
	{

         Movie thisMovie = (Movie) it.next();
   	%>
        		<div class="span3"><a href="#x" class="thumbnail"><img src="<%=thisMovie.getPosters().getDetailed()%>" alt="Image" style="max-width:100%;" /></a></div>
	<%
	    i++;
	
	    if (i == 4)
	    	break;
	}
	%>
    	</div><!--/row-fluid-->
    </div><!--/item-->
    <div class="item">
  		<div class="row-fluid">
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    	</div><!--/row-fluid-->
    </div><!--/item-->
    
    <div class="item">
    	<div class="row-fluid">
   			<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    		<div class="span3"><a href="#x" class="thumbnail"><img src="http://placehold.it/250x250" alt="Image" style="max-width:100%;" /></a></div>
    	</div><!--/row-fluid-->
    </div><!--/item-->
   
    </div><!--/carousel-inner-->
    
    <a class="left carousel-control" href="#myCarousel" data-slide="prev"><-</a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">-></a>
    </div><!--/myCarousel-->
</div><!--/well-->

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
    <script type="text/javascript">
    $(document).ready(function() {
   		 $('#myCarousel').carousel({
    	interval: 10000
    	})
    });
    </script>
</body>
