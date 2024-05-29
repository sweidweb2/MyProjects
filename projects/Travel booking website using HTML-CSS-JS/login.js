//register
let registerblock=document.getElementById("register-block");
let fnameinput=document.getElementById("fname");
let lnameinput=document.getElementById("lname");
let phoneinput=document.getElementById("phonenb");
let emailinput=document.getElementById("email");
let passinput=document.getElementById("pass1");
let confirmpassinput=document.getElementById("pass2");
let recieveemail=document.getElementById("recieve-email");
let agreement=document.getElementById("agreement");
let forwardsignin=document.getElementById("login-forward");
let register=document.getElementById("register-btn");
let errormsg=document.getElementById("register-error-message");
let emailmatch=/^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const strongPasswordRegex = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+{}|:;'<>,.?\/~`]).{8,}$/;

register.addEventListener("click",e=>{
    if(fnameinput.value==="" || fnameinput.value.length>15){
        errormsg.innerHTML="Enter your first name correctly!";
    }else if(lnameinput.value==="" || lnameinput.value.length>15){
        errormsg.innerHTML="Enter your last name correctly!";
    }else if(phoneinput.value==="" || phoneinput.value.length!=8){
        errormsg.innerHTML="Enter your phone number correctly!";
    }else if(!emailmatch.test(emailinput.value)){
        errormsg.innerHTML="Enter your email correctly!";
        console.log(emailmatch.test(emailinput.value))
    }else if(!strongPasswordRegex.test(passinput.value)){
        errormsg.innerHTML="your password should contain uppercase/special characters/numbers and at least 8 charcters!";
        console.log(strongPasswordRegex.test(passinput.value))
    }else if(!strongPasswordRegex.test(confirmpassinput.value) || confirmpassinput.value!=passinput.value){
        errormsg.innerHTML="Enter your confirmation password correctly!";
    }else if(!recieveemail.checked || !agreement.checked){        
        errormsg.innerHTML="you should agree with our qualifications!";
    }else{
        errormsg.innerHTML="";
        createaccount(fnameinput.value,lnameinput.value,phoneinput.value,emailinput.value,passinput.value);
        registerblock.style.display="none";
        loginblock.style.display="flex";
    }
})

let usersarray=[];

function createaccount(myfname,mylname,myphone,myemail,mypass){
    useraccount={
        fname:myfname,
        lname:mylname,
        phone:myphone,
        email:myemail,
        password:mypass
    }
    usersarray.push(useraccount);
}
userss={
    fname:"ali",
    lname:"sweid",
    phone:34534523,
    email:"asweid654@gmail.com",
    password:"ali123"
}
usersarray.push(userss)


let usernameinput=document.getElementById("login-username");
let loginemailinput=document.getElementById("login-email");
let loginpassinput=document.getElementById("login-pass");
let registerforward=document.getElementById("Register-forward");
let loginbtn=document.getElementById("login-btn");
let loginblock=document.getElementById("login-block");
let loginerror=document.getElementById("login-error-message");
let completelogin=document.getElementById("complete-login");

loginbtn.addEventListener("click",e=>{
    if(usernameinput.value==="" || loginemailinput.value==="" || loginpassinput.value===""){
        loginerror.innerHTML="Enter all information!";
    }

    for(let i=0;i<usersarray.length;i++){
        if(usersarray[i].email===loginemailinput.value){
            console.log("true email")
            if(usersarray[i].password===loginpassinput.value){
                console.log("true password")
                window.location.href = "./home1.html";
            }else{
                loginerror.innerHTML="Enter your password correctly!";
                console.log("false pass")
                console.log(usersarray[i])
                console.log(loginemailinput.value)
            }
        }else{
            loginerror.innerHTML="Enter your email correctly!";
            console.log("false email")
            console.log(usersarray[i])
            console.log(loginemailinput.value)
        }
    }
})

registerforward.addEventListener("click",e=>{
    loginblock.style.display="none";
    registerblock.style.display="flex";
})