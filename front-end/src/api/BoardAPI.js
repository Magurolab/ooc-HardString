import axios from './AxiosConfiguration'
import {withStyles} from "material-ui/styles/index";

class BoardAPI {
    fakeGame(){
        return axios.get("/debug/fakegame")
            .then((response) => ({data: response.data, status: response.status}))
        // .then(({data, status}) => ({data, status}))
    }

    showBoard(){
        return axios.get("/debug/showboard")
            .then(({data, status}) => ({data, status}))
    }

    attack(){
        return axios.post()
    }
}

export default new BoardAPI()

// export default withStyles(styles)(BoardAPI);




// import * as api from /...
