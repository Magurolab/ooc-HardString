var axios = require('axios');

module.exports = {
  fetchPopularRepos: function (language) {
    var encodeURI = window.encodeURI(
        'https://api.github.com/search/repositories?q=starts:>1+language:'+
        language +
        '&sort=starts&order=desc&type=Repositories'
        );
    return axios.get(encodeURI)
      .then(function (response) {
        return response.data.items;
        }
      );
    );
  }
}
