//variables
let prevbtn=document.getElementById("prevbtn");
let nextbtn=document.getElementById("nextbtn");
let headerimg=document.getElementById("header-images");
//filter variables
let filterexplorebtn=document.getElementById("filter-explore");
let locationinput=document.getElementById("location-input");

let resultimg=document.querySelectorAll("#filter-result-img");
let resultdesc=document.querySelectorAll("#filter-result-price");
let resultexplorebtn=document.querySelectorAll("#filter-result-btn");
//section 1 variable
let tourimg1=document.getElementById("tour-img-1");
let tourimg2=document.getElementById("tour-img-2");
let tourimg3=document.getElementById("tour-img-3");
//section 2 variables
let country1=document.getElementById("section2-country-1");
let country2=document.getElementById("section2-country-2");
let country3=document.getElementById("section2-country-3");
let country1img=document.getElementById("country-img-1");
let country2img=document.getElementById("country-img-2");
let country3img=document.getElementById("country-img-3");
//section 3 variables
let section3img=document.getElementById("section3-img")
let joinsection3img=document.getElementById("section3-img-btn")

//section4 variables(according for the run section 4)
let whychooseus=document.getElementById("why-choose-us-img");

//services page variables
let servicecontainer=document.getElementById("service-items");

//footer variable
let forwardabout=document.querySelectorAll("#footer-forward-about");

/*hson catalog
1.germany:5         / id:1      /I.C.F:5
2.argentina:5       / id:2      /I.C.F:10
3.australia:5       / id:3      /I.C.F:15
4.canada:6          / id:4      /I.C.F:21
5.china:8           / id:5      /I.C.F:29
6.egypt:5           / id:6      /I.C.F:34
7.france:5          / id:7      /I.C.F:39
8.iran:7            / id:8      /I.C.F:46
9.lebanon:5         / id:9      /I.C.F:51
10.russia:5         / id:10     /I.C.F:56
11.saudia:4         / id:11     /I.C.F:60
12.turkey:9         / id:12     /I.C.F:69
12.UK:5             / id:13     /I.C.F:74
13.tours:3          / id:14     /I.C.F:77
*/


// start code
var myimages="./project.json";

for(s=0;s<resultexplorebtn.length;s++){
    resultexplorebtn[s].addEventListener("click",e=>{
        window.location.href = "./service.html";
        console.log("yes")
    })
}
for(s1=0;s1<forwardabout.length;s1++){
    forwardabout[s1].addEventListener("click",e=>{
        window.location.href = "./about.html";
        console.log("yes")
    })
}
joinsection3img.addEventListener("click",e=>{
    window.location.href = "./service.html";
})

fetch(myimages)
.then(res=>res.json())
.then(data=>{
    console.log(data)

    headerimg.src=data[23].lowURL;
    //declaring my header images array
    let imagesarray=[];
    imagesarray.push(data[0].lowURL);1
    imagesarray.push(data[1].lowURL);2
    imagesarray.push(data[2].lowURL);3
    imagesarray.push(data[3].lowURL);4
    imagesarray.push(data[4].lowURL);5
    imagesarray.push(data[5].lowURL);6
    imagesarray.push(data[6].lowURL);7
    imagesarray.push(data[7].lowURL);8
    imagesarray.push(data[8].lowURL);9
    imagesarray.push(data[9].lowURL);10
    imagesarray.push(data[10].lowURL);11
    imagesarray.push(data[11].lowURL);12
    imagesarray.push(data[12].lowURL);13
    imagesarray.push(data[13].lowURL);14
    imagesarray.push(data[14].lowURL);15
    imagesarray.push(data[15].lowURL);16
    imagesarray.push(data[16].lowURL);17
    console.log(imagesarray)

    //interval to flip image every 5 sec.
    let i=0;
    setInterval(function() {
    if(i==imagesarray.length-1){
        i=0;
        headerimg.src=imagesarray[i];
    }else{
        headerimg.src=imagesarray[i];
        i++;
    }

    }, 2000);

    //the header next arrow
    nextbtn.addEventListener("click",()=>{
        if(i==imagesarray.length-1){
            i=0;
            headerimg.src=imagesarray[i];
            i++;
        }else{
            headerimg.src=imagesarray[i+1];
            i++;
        }
    })

    //the header prev arrow
    prevbtn.addEventListener("click",()=>{
        if(i==0){
            i=imagesarray.length;
            headerimg.src=imagesarray[i-1];
            i=i-1;
        }else{
            headerimg.src=imagesarray[i-1];
            i=i-1;
        }
    })

    //when enter tapped for filter
    locationinput.addEventListener("keydown",e=>{
        if(e.key==="Enter"){
            filterexplorebtn.click();
        }
    })
    //filter functionality
    filterexplorebtn.addEventListener("click",function(){
        let loc=locationinput.value;
        let locarray=[];
        let locid

        data.forEach(place => {
            if(loc===place.name){
                locid=place.id;
                locarray.push(place)
            }
        });
        data.forEach(place => {
            if(place.id==locid && locarray[0]!=place){
                locarray.push(place)
            }
        });

        resultimg[0].src=locarray[0].lowURL;
        resultimg[1].src=locarray[1].lowURL;
        resultimg[2].src=locarray[2].lowURL;
        resultimg[3].src=locarray[3].lowURL;
        resultimg[4].src=locarray[4].lowURL;

        resultdesc[0].innerHTML=`${locarray[0].name}<br>$${locarray[0].price*locarray[0].nbdays}`;
        resultdesc[1].innerHTML=`${locarray[1].name}<br>$${locarray[1].price*locarray[1].nbdays}`;
        resultdesc[2].innerHTML=`${locarray[2].name}<br>$${locarray[2].price*locarray[2].nbdays}`;
        resultdesc[3].innerHTML=`${locarray[3].name}<br>$${locarray[3].price*locarray[3].nbdays}`;
        resultdesc[4].innerHTML=`${locarray[4].name}<br>$${locarray[4].price*locarray[4].nbdays}`;
    })

    //section 2 tour imgs
        tourimg1.src=data[74].lowURL;
        tourimg2.src=data[75].lowURL;
        tourimg3.src=data[76].lowURL;

    //section 3 images

    country1.classList.add("active");
    country2.classList.remove("active");
    country3.classList.remove("active");
    country1img.src=data[60].lowURL;
    country2img.src=data[61].lowURL;
    country3img.src=data[62].lowURL;

    country1.addEventListener("click",e=>{
        country1.classList.add("active");
        country2.classList.remove("active");
        country3.classList.remove("active");
        country1img.src=data[60].lowURL;
        country2img.src=data[61].lowURL;
        country3img.src=data[62].lowURL;
    });

    country2.addEventListener("click",e=>{
        country1.classList.remove("active");
        country2.classList.add("active");
        country3.classList.remove("active");
        country1img.src=data[46].lowURL;
        country2img.src=data[47].lowURL;
        country3img.src=data[48].lowURL;
    });

    country3.addEventListener("click",e=>{
        country1.classList.remove("active");
        country2.classList.remove("active");
        country3.classList.add("active");
        country1img.src=data[39].lowURL;
        country2img.src=data[40].lowURL;
        country3img.src=data[41].lowURL;
    });

    section3img.src=data[27].lowURL;

    


})//the fetching close tag