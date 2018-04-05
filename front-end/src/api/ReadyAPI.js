import axios from "./AxiosConfiguration";

class ReadyAPI {

    ready(){
        return axios.post('/ready')
    }


}
export default new ReadyAPI()