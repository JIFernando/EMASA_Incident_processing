var geocoder;
var map;
function initialize()
{
    geocoder = new google.maps.Geocoder();
    var myLatLng = {lat: 36.716427, lng: -4.470143};
    map = new google.maps.Map(document.getElementById("map"),
            {
                zoom: 14,
                center: new google.maps.LatLng(36.716427, -4.470143),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Universidad de Malaga',
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


