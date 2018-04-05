import axios from "./AxiosConfiguration";

class LoginAPI {

    login(username, password){
        // console.log("L:LLLL");
        return axios.post('/login',{
            username,
            password,

        }).then(
            () => {console.log("Logging in")}
        )
    }
}
export default new LoginAPI()