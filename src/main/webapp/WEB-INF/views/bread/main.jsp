<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=mq0vmu9bxl&callback=bread_nmap"></script>
</head>
<body>
	<div>
		<div id="mapDiv" style="width:80%; height:400px; margin: 0 auto;"></div>
        <script>
            function bread_nmap(){

                // map location list(map)
//                 let nmap_loc = ${breadStore};
                let nmap_loc = [{"BREAD_STORE_NM":"성심당 본점","BREAD_STORE_LOC_LNG":"127.427431","BREAD_STORE_LOC_LAT":"36.327701","BREAD_STORE_USE_YN":"Y"},{"BREAD_STORE_NM":"성심당 대전역점","BREAD_STORE_LOC_LNG":"127.4339","BREAD_STORE_LOC_LAT":"36.3322","BREAD_STORE_USE_YN":"Y"},{"BREAD_STORE_NM":"성심당 DCC점","BREAD_STORE_LOC_LNG":"127.3925","BREAD_STORE_LOC_LAT":"36.3753","BREAD_STORE_USE_YN":"Y"},{"BREAD_STORE_NM":"파리바게뜨 대전한빛점","BREAD_STORE_LOC_LNG":"127.3567","BREAD_STORE_LOC_LAT":"36.3631","BREAD_STORE_USE_YN":"Y"}];
                
                console.log(nmap_loc);
//                 let nmap_loc = [
//                     {
//                         lat: 36.3405969725126,
//                         lng: 127.38961188259837,
//                     },
//                     {
//                         lat: 36.3514,
//                         lng: 127.395,
//                     },
//                     {
//                         lat: 36.35199250714498,
//                         lng: 127.37260406909178,
//                     },
//                 ]

                // create map
                let mapOptions = {
                    center: new naver.maps.LatLng(36.3530, 127.3939),
                    zoom: 13,
                }
                let map_view = new naver.maps.Map('mapDiv', mapOptions);

                // map print marker
                for(let i=0; i<nmap_loc.length; i++){
                    let mapMarker = new naver.maps.Marker({
                        position: new naver.maps.LatLng(nmap_loc[i].BREAD_STORE_LOC_LAT, nmap_loc[i].BREAD_STORE_LOC_LNG),
                        map: map_view,
                        icon: {
                            url: "/img/nmap_marker.png",
                            size: new naver.maps.Size(43, 43),
                            scaledSize: new naver.maps.Size(43, 43),
                        },
                        zIndex: 999,
                    });
                }
            }
        </script>
        ${breadStore}
	</div>
</body>
</html>