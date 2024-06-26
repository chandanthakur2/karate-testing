function fn() {
    var env = karate.env || 'dev'; // default to 'dev' if not set
    karate.log('karate.env system property was:', env);

    // read the yaml file
    var config = karate.read('classpath:config.yml');

    // set the configuration for the current environment
    var envConfig = config[env];

    if (!envConfig) {
        karate.log('Environment "' + env + '" not found in config.yml, defaulting to "dev"');
        envConfig = config.dev;
    }

    // you can add more default configurations here
    var defaultConfig = {
        // Add any default configurations that apply to all environments
    };

    // combine the default config with the environment-specific config
    var finalConfig = karate.merge(defaultConfig, envConfig);

    return finalConfig;
}