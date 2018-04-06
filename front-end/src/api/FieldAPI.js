import axios from "./AxiosConfiguration";

class FieldAPI {

    attack(cardId, index ){
        console.log("Ja sent la na ",cardId, index);

        return axios.post("/board/attack",{
            currentmonster:cardId,
            enemymonster: index
        })
    }
}
export default new FieldAPI()