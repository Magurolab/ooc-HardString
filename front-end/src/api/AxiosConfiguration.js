import Axios from "axios"
import QS from 'qs'

// const URL = process.env.NODE_ENV !== 'development' ? 'https://api.iot-inventory.teparak.me'  : 'http://localhost:8080'

const axios = new Axios.create({
    baseURL: 'http://localhost:8080',
    withCredentials: true,
    headers: {
        common: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
    },
    transformRequest: (data) => QS.stringify(data)

})

export default axios