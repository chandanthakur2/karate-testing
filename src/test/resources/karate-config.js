

function fn() {
    var env = karate.call('classpath:env.js');
    var common = karate.call('classpath:common.js');

    karate.configure('connectTimeout', 30000);
    karate.configure('readTimeout', 30000);
    karate.configure('ssl', true);

    return {
        env: env,
        common: common
    };
}