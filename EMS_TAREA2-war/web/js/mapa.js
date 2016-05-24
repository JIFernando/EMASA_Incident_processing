var geocoder;
var map;
function initialize()
{
    geocoder = new google.maps.Geocoder();
    map = new google.maps.Map(document.getElementById("map"),
            {
                zoom: 8,
                center: new google.maps.LatLng(22.7964, 79.5410),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });
}

function codeAddress()
{
    var address = document.getElementById("address").value;
    var coord = document.getElementById("coordenadas");
    geocoder.geocode({'address': address}, function (results, status)
    {
        if (status == google.maps.GeocoderStatus.OK)
        {
            var latitude = results[0].geometry.location.lat();
            var longitude = results[0].geometry.location.lng();
            coord.value = latitude + "," + longitude;
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker(
                    {
                        map: map,
                        title: 'AVISO',
                        position: results[0].geometry.location
                    });
        } else
        {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });

}
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


