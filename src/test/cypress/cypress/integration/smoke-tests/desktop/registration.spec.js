/// <reference types="cypress" />

describe('homepage tests', () => {
    const urlLocalHome = 'http://localhost:8080/'
    const urlLocalRegister = 'localhost:8080/register'
    beforeEach(() => {
        cy.visit(urlLocalRegister)
    })

    it('registration page is available', () => {

        cy.visit(urlLocalHome)

        cy.get('#register')
            .should('be.visible')
            .click()

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

        cy.get('div > form')
            .should('be.visible')
    })

    it('form can be submitted ', () => {

        cy.get('#username')
            .should('be.visible')
            .type("MusterMax")

        cy.get('#password')
            .should('be.visible')
            .type('Test123!')

        cy.get('#submitButton')
            .should('be.visible')
            .click()

        cy.url().should('eq', urlLocalHome + "?success")

        cy.get('#successMessage').should('be.visible')
    })
})