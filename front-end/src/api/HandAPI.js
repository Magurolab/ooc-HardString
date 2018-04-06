import axios from "./AxiosConfiguration";

class HandAPI {

    playCard(cardId, index ){
        // console.log(cardId, index)
        return axios.post("/hand/usecard",{
            cardId:cardId,
            index: index
        })
    }
}
export default new HandAPI()