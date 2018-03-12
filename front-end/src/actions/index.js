import axios from "axios";

export function loadText(){
    return((dispatch)=>{
            return axios.get("http://localhost:8080/greeting").then((response)=>{
                    dispatch(printText(response.data.content));
            })
    })
}

export function printText(text){
    return({
        type:"just_text",
        content:text

    })
}

