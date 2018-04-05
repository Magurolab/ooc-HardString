import axios from "./AxiosConfiguration";

class LoginAPI {

    login(username, password){
        // console.log("L:LLLL");
        return axios.post('/login',{
            username,
            password,

        })
    }

    whoami(){
        console.log("hello heloo");
        return axios.get('/whoami')
            .then(({data, status}) => (console.log(status)))

    }

    logout(){

    }
}
export default new LoginAPI()