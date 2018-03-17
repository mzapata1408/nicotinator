var Home = Home || (function($, w, undefined){

    function _init(){

        $('#flavouring').autocomplete({
            source: '/flavourings/autocomplete',
            minLength: 3,
            delay: 300
        })
    }

    return {
        init: _init
    }
})(jQuery, window);