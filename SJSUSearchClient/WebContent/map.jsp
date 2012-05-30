<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCCaZ4csil6aMfWpxd5PHAOALkulXUSXpI&sensor=true">
    </script>
    <script type="text/javascript">
      function initialize() {
          var x=37.20;
          var y=-121.53;
        var myOptions = {
          center: new google.maps.LatLng(x,y),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
          
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);

		var image='balloon.png';
		var myLatLng = new google.maps.LatLng(x,y);
		var marker = new google.maps.Marker({
			position: myLatLng,
			map: map,
			icon:image
			});
               
      }
    </script>
  </head>
  <body onload="initialize()">
    <div id="map_canvas" style="width:50%; height:50%"></div>
  </body>
</html>