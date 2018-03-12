let defaultState={
    content:"default text na ja"
}

const mainReducer=(state=defaultState, action)=>{

    if(action.type==="just_text"){
        return {
            ...state,
            content:action.content
        }
    }else{
        return{
            ...state
        }

    }
}
export default mainReducer;