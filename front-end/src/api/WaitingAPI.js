import axios from "./AxiosConfiguration";

class WaitingAPI {

    wait(){
        return axios.get('/queue')
            .then(({data, status}) => ({
                data, status

            }))
    }


}
export default new WaitingAPI()