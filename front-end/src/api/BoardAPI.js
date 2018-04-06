import axios from './AxiosConfiguration'
import {withStyles} from "material-ui/styles/index";

class BoardAPI {
    fakeGame(){
        return axios.get("/board")
            .then((response) => ({data: response.data, status: response.status}))
        // .then(({data, status}) => ({data, status}))
    }

    showBoard(){
        return axios.get("/board")
            .then(({data, status}) => ({data, status}))
    }

    attack(currentPos, targetPos){
        return axios.post("/board/attack",{
            currentMonster: currentPos,
            enemyMonster: targetPos
        })
    }

    endTurn(){
        return axios.post("/board/endturn")
    }
}

export default new BoardAPI()

// export default withStyles(styles)(BoardAPI);




// import * as api from /...
