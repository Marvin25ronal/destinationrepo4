const assert = require('chai').assert;
const expect = require('chai').expect;
require('chai').should;

const selenium = require('../src/Selenium.js');


describe('Prueba de selenium', () => {
    it('Formulario de login', (done) => {
        try {
            selenium.llenar_formulario(done);
        } catch (err) {
            throw err;
        }
    })
})