import axios from './AxiosConfiguration'

export default class BoardAPI {
    fakeGame(){
        return axios.get("/debug/fakegame")
            .then(({data, status}) => ({data, status}))
    }
}