require.config({

    paths: {
        'angular':          '../lib/angular/angular',
        'angular-route':    '../lib/angular-route/angular-route',
        'domReady':         '../lib/requirejs-domready/domReady',
        'angular-bootstrap':'../lib/angular-bootstrap/ui-bootstrap-tpls',
        'angular-confirm-modal':'../lib/angular-confirm-modal/angular-confirm'
    },


    shim: {
        'angular':                  { exports:  'angular'},
        'angular-route':            { deps:     ['angular']},
        'angular-bootstrap':        { deps:     ['angular']},
        'angular-confirm-modal':    { deps:     ['angular']}
    },

    priority: [
        'angular'
    ],

    deps: [

        './bootstrap'
    ]
});