/// <reference types="cypress" />

describe('homepage tests', () => {
    const urlLocalHome = 'localhost:8080/'
    const urlLocalRegister = 'localhost:8080/register'
    beforeEach(() => {
        cy.visit(urlLocalHome)
        cy.viewport('iphone-8')
    })

    it('registration page is available', () => {

        cy.request({
            url: urlLocalRegister,
            followRedirect: false // turn off following redirects
        })
            .then((resp) => {
                expect(resp.status).to.eq(200)
            })

    })

    it('registration form is visible', () => {

        cy.get('h1')
            .should('be.visible')

        cy.get('#username')
            .should('be.visible')
            .type("MusterMax")

        cy.get('#password')
            .should('be.visible')
            .type('Test123!')

        cy.get('#submitButton')
            .should('be.visible')
            .click()

        cy.url().should('eq', urlLocalHome)
    })
})
