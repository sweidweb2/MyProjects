//variables
let prevbtn=document.getElementById("prevbtn");
let nextbtn=document.getElementById("nextbtn");
let headerimg=document.getElementById("header-images");
//services page variables
let servicecontainer=document.getElementById("service-items");
let serviceitem=document.getElementsByClassName("service-item");
let billingpage=document.getElementById("billing-page");

//service-filter-variables
let filtercontainer=document.getElementById("service-filter");
let filterexplore=document.getElementById("service-filter-explore");
let locationinput=document.getElementById("service-location-input");
let dateinput=document.getElementById("service-date-input");
let peopleinput=document.getElementById("service-people-input");
//footer variable
let forwardabout=document.querySelectorAll("#footer-forward-about");


//forward links
for(s1=0;s1<forwardabout.length;s1++){
    forwardabout[s1].addEventListener("click",e=>{
        window.location.href = "./about.html";
        console.log("yes")
    })
}
//ordersarray
let orderarray=[];
function createorders(myemail,myticket,myday){
    const order={
        email:myemail,
        ticket:myticket,
        date:myday
    };
    orderarray.push(order);
    console.log(order);
}
console.log(orderarray);
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
13.tours:3          / id:14     /I.C.F:77*/



// start code
var myimages="./project.json";

fetch(myimages)
.then(res=>res.json())
.then(data=>{
    console.log(data)

    headerimg.src=data[20].lowURL;
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
    headerimg.src=imagesarray[5]

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

    let randomNumber;
    let randomarray=[];
    for(let a=0;a<74;a++){
        do{
            randomNumber = Math.floor(Math.random()*74);
        }while(randomarray.includes(randomNumber));
        randomarray.push(randomNumber);
    }
    var k=20;
    for(let j=0;j<k;j++){
        nbstars=""
        for(z=0;z<data[randomarray[j]].rate;z++){
            nbstars=nbstars+"⭐";
        }
        
    
        let card=`
            <div class="service-item" id="service-item">
                <img src="${data[randomarray[j]].lowURL}" alt="" class="service-item-img">
                <div class="stars-service">${nbstars}</div>
                
                <div class="service-item-loc">
                    <p><i class="fa-solid fa-location-dot"></i>${data[randomarray[j]].mothercountry},${data[randomarray[j]].name}</p>
                    <p><i class="fa-regular fa-clock"></i> ${data[randomarray[j]].nbdays} days</p>
                    <p><i class="fa-solid fa-money-check-dollar"></i> ${data[randomarray[j]].price*data[randomarray[j]].nbdays}$</p>
                </div>
                <div class="service-item-book">
                    <span id="book-tour" class="book-tour">Book <i class="fa-regular fa-share-from-square"></i></span>
                </div>
            </div>`;
        servicecontainer.innerHTML=servicecontainer.innerHTML+card;
        
        if(j==k-1){
            servicecontainer.innerHTML=servicecontainer.innerHTML+`<div class="load-more-container"><span class="load-more" id="load-more">Load More</span></div>`;
        }
    }
    document.querySelectorAll('.book-tour').forEach((bookButton, index) => {
        bookButton.addEventListener('click', () => {
            console.log(`Book button clicked for card ${index}`);
            // Use querySelectorAll to select all elements with class 'service-item'
            document.querySelectorAll('.service-item').forEach(item => {
                item.style.display = "none";
            });
            const today = new Date().toLocaleDateString('en-LB');
            servicecontainer.innerHTML=`
                <div class="billing-page" id="billing-page""> 
                    <img src="${data[randomarray[index]].highURL}" alt="" class="service-order-img">
                    <h1>Check Out</h1>
                    <div class="order">
                        <div class="billing-desc">
                            <img src="${data[randomarray[index]].highURL}" alt="">
                            <div class="billing-calculation">
                                <p>Date: ${today}</p>
                                <p>Duration:${data[randomarray[index]].nbdays} days</p>
                                <p>Departure from: ${data[randomarray[index]].name}</p>
                                <p>Departure time:</p>
                                <p>Tickets:1</p>
                                <p>Total: ${data[randomarray[index]].price*data[randomarray[index]].nbdays}$</p>
                                <span class="return" id="return">Return</span>
                            </div>
                        </div>
                        <div class="costumer-desc">
                            <input type="text" name="fname" placeholder="First name" id="costumer-desc-fname" class="costumer-desc-fname">
                            <input type="text" name="lname" placeholder="Last name" id="costumer-desc-lname" class="costumer-desc-lname">
                            <input type="text" name="email" placeholder="Email" id="costumer-desc-email" class="costumer-desc-email">
                            <input type="text" name="phone" placeholder="Phone Number" id="costumer-desc-phone" class="costumer-desc-phone">
                            <p>Amount to pay now</p>
                            <h5 class="inputs-tester" id="inputs-tester"></h5>
                            <label for="agree">
                                <input type="checkbox" name="agree" id="costumer-desc-phone" class="costumer-desc-agreement">
                                i read and agree to the terns and conditions
                            </label>
                            <span class="complete-order" id="complete-order">Complete My Order</span>
                        </div>
                    </div>
                </div>`;
                document.getElementById("return").addEventListener("click",e=>{
                    document.getElementById("billing-page").style.display="none";
                })
                let fnameinput=document.getElementById("costumer-desc-fname");
                let lnameinput=document.getElementById("costumer-desc-lname");
                let emailinput=document.getElementById("costumer-desc-email");
                let phoneinput=document.getElementById("costumer-desc-phone");
                let emailmatch=/\w+@(gmail|hotmail|mail).(com|net)/ig;
                
                document.getElementById("complete-order").addEventListener("click",e=>{
                    if(fnameinput.value==="" || lnameinput.value==="" || emailinput.value==="" || phoneinput.value===""){
                        document.getElementById("inputs-tester").innerHTML=`enter your information correctly`;
                    }else if((emailmatch.test((emailinput.value).toString())===false)){
                        document.getElementById("inputs-tester").innerHTML=`enter your email correctly`;
                    }else if(phoneinput.value.length<8){
                        document.getElementById("inputs-tester").innerHTML=`enter your phone number correctly`
                    }else{
                        alert("your booking done succefully");
                        createorders(emailinput.value,data[randomarray[index]].name,today)
                        location.reload();
                    }            
                })
            
        });
    });

    let loadmore=document.getElementById("load-more");
    loadmore.addEventListener("click",e=>{
        if((74-k)>20){
            k=k+40;
            servicecontainer.innerHTML="";
            console.log("i am here")
            for(let j=0;j<k;j++){

                nbstars=""
                for(z=0;z<data[randomarray[j]].rate;z++){
                    nbstars=nbstars+"⭐";
                }
            
                let card=`
                <div class="service-item">
                    <img src="${data[randomarray[j]].lowURL}" alt="" class="service-item-img">
                    <div class="stars-service">${nbstars}</div>
                    
                    <div class="service-item-loc">
                        <p><i class="fa-solid fa-location-dot"></i>${data[randomarray[j]].mothercountry},${data[randomarray[j]].name}</p>
                        <p><i class="fa-regular fa-clock"></i> ${data[randomarray[j]].nbdays} days</p>
                        <p><i class="fa-solid fa-money-check-dollar"></i> ${data[randomarray[j]].price*data[randomarray[j]].nbdays}$</p>
                    </div>
                    <div class="service-item-book">
                        <span id="book-tour" class="book-tour-loaded">Book <i class="fa-regular fa-share-from-square"></i></span>
                    </div>
                </div>`;
                servicecontainer.innerHTML=servicecontainer.innerHTML+card;
            }
            document.querySelectorAll('.book-tour-loaded').forEach((bookButton, index) => {
                bookButton.addEventListener('click', () => {
                    console.log(`Book button clicked for card ${index}`);
                    // Use querySelectorAll to select all elements with class 'service-item'
                    document.querySelectorAll('.service-item').forEach(item => {
                        item.style.display = "none";
                    });
                    console.log(billingpage);
                    const today = new Date().toLocaleDateString('en-LB');
                    servicecontainer.innerHTML=`
                        <div class="billing-page" id="billing-page""> 
                            <img src="${data[randomarray[index]].highURL}" alt="" class="service-order-img">
                            <h1>Check Out</h1>
                            <div class="order">
                                <div class="billing-desc">
                                    <img src="${data[randomarray[index]].highURL}" alt="">
                                    <div class="billing-calculation">
                                        <p>Date: ${today}</p>
                                        <p>Duration: ${data[randomarray[index]].nbdays} days</p>
                                        <p>Departure from: ${data[randomarray[index]].name}</p>
                                        <p>Departure time:</p>
                                        <p>Tickets:</p>
                                        <p>Total: ${data[randomarray[index]].price*data[randomarray[index]].nbdays}$</p>
                                        <span class="return" id="return">Return</span>
                                    </div>
                                </div>
                                <div class="costumer-desc">
                                    <input type="text" name="fname" placeholder="First name" id="costumer-desc-fname" class="costumer-desc-fname">
                                    <input type="text" name="lname" placeholder="Last name" id="costumer-desc-lname" class="costumer-desc-lname">
                                    <input type="text" name="email" placeholder="Email" id="costumer-desc-email" class="costumer-desc-email">
                                    <input type="text" name="phone" placeholder="Phone Number" id="costumer-desc-phone" class="costumer-desc-phone">
                                    <p>Amount to pay now</p>
                                    <h5 class="inputs-tester" id="inputs-tester"></h5>
                                    <label for="agree">
                                        <input type="checkbox" name="agree" id="costumer-desc-phone" class="costumer-desc-agreement">
                                        i read and agree to the terns and conditions
                                    </label>
                                    <span class="complete-order" id="complete-order">Complete My Order</span>
                                </div>
                            </div>
                        </div>`
                    document.getElementById("return").addEventListener("click",e=>{
                        document.getElementById("billing-page").style.display="none";
                    })
                    let fnameinput=document.getElementById("costumer-desc-fname");
                    let lnameinput=document.getElementById("costumer-desc-lname");
                    let emailinput=document.getElementById("costumer-desc-email");
                    let phoneinput=document.getElementById("costumer-desc-phone");
                    let emailmatch=/\w+@(gmail|hotmail|mail).(com|net)/ig;
                    
                    document.getElementById("complete-order").addEventListener("click",e=>{
                        if(fnameinput.value==="" || lnameinput.value==="" || emailinput.value==="" || phoneinput.value===""){
                            document.getElementById("inputs-tester").innerHTML=`enter your information correctly`;
                        }else if((emailmatch.test((emailinput.value).toString())===false)){
                            document.getElementById("inputs-tester").innerHTML=`enter your email correctly`;
                        }else if(phoneinput.value.length<8){
                            document.getElementById("inputs-tester").innerHTML=`enter your phone number correctly`
                        }else{
                            alert("your booking done succefully");
                            createorders(emailinput.value,data[randomarray[index]].name,today)
                            location.reload();
                        }            
                    })
                });
            });
        }
        //ma kenet tozbat la2eno eventlistener mish 3m yo2ra hal id la2eno bi albo
        //servicecontainer.innerHTML=servicecontainer.innerHTML+`<div class="load-more-container"><span class="load-more" id="load-more">Load More</span></div>`;
    })
    let regionsarray=[]
    filterexplore.addEventListener("click",e=>{
        const userdateinput=dateinput.value;
        const userinputstring=userdateinput.toString();
        const usercomponents=userinputstring.split("-");
        const userday=usercomponents[2];
        const usermonth=usercomponents[1];
        const useryear=usercomponents[0];
        console.log(usercomponents)
        console.log(userday)
        console.log(usermonth)
        console.log(useryear)


        const today = new Date().toLocaleDateString('en-LB');
        const todaydatestring=today.toString();
        const mycomponents=todaydatestring.split("/");
        const myday=mycomponents[1];
        const mymonth=mycomponents[0];
        const myyear=mycomponents[2];
        console.log(todaydatestring);
        console.log(myday);
        console.log(mymonth);
        console.log(myyear);

        let loc=locationinput.value;
        let locid;
        if(loc!==""){
            data.forEach(region => {
                if(loc===region.name || loc===region.mothercountry){
                    locid=region.id;
                }
            });
            servicecontainer.innerHTML="";
            regionsarray=[];
            data.forEach(region => {
                if(region.id==locid){
                    nbstars="";
                    for(z=0;z<region.rate;z++){
                        nbstars=nbstars+"⭐";
                    }
                    
                    regionsarray.push(region);    
                    let resultcard=`
                        <div class="service-item">
                            <img src="${region.lowURL}" alt="" class="service-item-img">
                            <div class="stars-service">${nbstars}</div>
                            
                            <div class="service-item-loc">
                                <p><i class="fa-solid fa-location-dot"></i>${region.mothercountry},${region.name}</p>
                                <p><i class="fa-regular fa-clock"></i> ${region.nbdays} days</p>
                                <p><i class="fa-solid fa-money-check-dollar"></i> ${region.price*region.nbdays}$</p>
                            </div>
                            <div class="service-item-book">
                                <span id="book-tour" class="book-tour">Book <i class="fa-regular fa-share-from-square"></i></span>
                            </div>
                        </div>`;
                    servicecontainer.innerHTML=servicecontainer.innerHTML+resultcard;
                    document.querySelectorAll('.book-tour').forEach((bookButton, index) => {
                        bookButton.addEventListener('click', () => {
                            console.log(`Book button clicked for card ${index}`);
                            // Use querySelectorAll to select all elements with class 'service-item'
                            document.querySelectorAll('.service-item').forEach(item => {
                                item.style.display = "none";
                            });
                            console.log(billingpage);
                            servicecontainer.innerHTML=`
                                <div class="billing-page" id="billing-page""> 
                                    <img src="${regionsarray[index].highURL}" alt="" class="service-order-img">
                                    <h1>Check Out</h1>
                                    <div class="order">
                                        <div class="billing-desc">
                                            <img src="${regionsarray[index].highURL}" alt="">
                                            <div class="billing-calculation">
                                                <p>Date:${today}</p>
                                                <p>Duration: ${regionsarray[index].nbdays} days</p>
                                                <p>Departure from: ${regionsarray[index].name}</p>
                                                <p>Departure time:</p>
                                                <p>Tickets:1</p>
                                                <p>Total:${regionsarray[index].price*regionsarray[index].nbdays}$</p>
                                                <span class="return" id="return">Return</span>
                                            </div>
                                        </div>
                                        <div class="costumer-desc">
                                            <input type="text" name="fname" placeholder="First name" id="costumer-desc-fname" class="costumer-desc-fname">
                                            <input type="text" name="lname" placeholder="Last name" id="costumer-desc-lname" class="costumer-desc-lname">
                                            <input type="text" name="email" placeholder="Email" id="costumer-desc-email" class="costumer-desc-email">
                                            <input type="text" name="phone" placeholder="Phone Number" id="costumer-desc-phone" class="costumer-desc-phone">
                                            <p>Amount to pay now</p>
                                            <h5 class="inputs-tester" id="inputs-tester"></h5>
                                            <label for="agree">
                                                <input type="checkbox" name="agree" id="costumer-desc-phone" class="costumer-desc-agreement">
                                                i read and agree to the terns and conditions
                                            </label>
                                            <span class="complete-order" id="complete-order">Complete My Order</span>
                                        </div>
                                    </div>
                                </div>`
                            document.getElementById("return").addEventListener("click",e=>{
                                document.getElementById("billing-page").style.display="none";
                                
                            })
                            let fnameinput=document.getElementById("costumer-desc-fname");
                            let lnameinput=document.getElementById("costumer-desc-lname");
                            let emailinput=document.getElementById("costumer-desc-email");
                            let phoneinput=document.getElementById("costumer-desc-phone");
                            let emailmatch=/\w+@(gmail|hotmail|mail).(com|net)/ig;
                            
                            document.getElementById("complete-order").addEventListener("click",e=>{
                                if(fnameinput.value==="" || lnameinput.value==="" || emailinput.value==="" || phoneinput.value===""){
                                    document.getElementById("inputs-tester").innerHTML=`enter your information correctly`;
                                }else if((emailmatch.test((emailinput.value).toString())===false)){
                                    document.getElementById("inputs-tester").innerHTML=`enter your email correctly`;
                                }else if(phoneinput.value.length<8){
                                    document.getElementById("inputs-tester").innerHTML=`enter your phone number correctly`
                                }else{
                                    alert("your booking done succefully");
                                    createorders(emailinput.value,data[randomarray[index]].name,today)
                                    location.reload();
                                }            
                            })
                        });
                    });
                    if(useryear<myyear){
                        servicecontainer.innerHTML="";
                        servicecontainer.innerHTML=`
                        <div class="notfound-container">
                            <img src="./image/not-found.png" alt="" class="notfound-img">
                        </div>`;
                    }
                    if(usermonth<mymonth){
                        servicecontainer.innerHTML="";
                        servicecontainer.innerHTML=`
                        <div class="notfound-container">
                            <img src="./image/not-found.png" alt="" class="notfound-img">
                        </div>`;
                    }
                    if(userday<myday){
                        servicecontainer.innerHTML="";
                        servicecontainer.innerHTML=`
                        <div class="notfound-container">
                            <img src="./image/not-found.png" alt="" class="notfound-img">
                        </div>`;
                    }
                    if(peopleinput.value<0){
                        servicecontainer.innerHTML="";
                        servicecontainer.innerHTML=`
                        <div class="notfound-container">
                            <img src="./image/not-found.png" alt="" class="notfound-img">
                        </div>`;
                    }
                }
            });
        }     
    })
})