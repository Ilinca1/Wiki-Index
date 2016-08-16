module.exports = function (grunt) {
    grunt.initConfig({
        browserSync: {
            bsFiles: {
                src: 'app'
            },
            options: {
                server: {
                    baseDir: 'app',
                    routes: {
                        '/node_modules': './node_modules'
                    }
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-browser-sync');



    grunt.registerTask('default', ['browserSync']);
};