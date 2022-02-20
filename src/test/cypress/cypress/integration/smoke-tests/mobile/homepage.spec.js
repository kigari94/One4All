/// <reference types="cypress" />

describe('homepage tests', () => {
    const urlLocal = 'localhost:8080/'
    beforeEach(() => {
        cy.visit(urlLocal)
    })

    it('homepage is available', () => {

        cy.request({
            url: urlLocal,
            followRedirect: false // turn off following redirects
        })
            .then((resp) => {
                expect(resp.status).to.eq(200)
            })
    })

    it('main navigation is available', () => {

        cy.get('.header')
            .should('be.visible')
        cy.get('.logo')
            .should('be.visible')
        cy.get('.navigation')
            .should('be.visible')
        cy.get('.navigation > ul > li:nth-child(1) > a')
            .should('have.attr', 'href')
            .and('include', '/')
        cy.get('.navigation > ul > li:nth-child(2) > a')
            .should('have.attr', 'href')
            .and('include', '/login')
        cy.get('.navigation > ul > li:nth-child(3) > a')
            .should('have.attr', 'href')
            .and('include', '/register')
    })

    it('stage slider is available', () => {

        cy.get('#one4AllCarousel')
            .should('be.visible')
        cy.get('.carousel-control-prev')
            .should('be.visible')
        cy.get('.carousel-control-next')
            .should('be.visible')
    })

    it('filter navigation is available', () => {

        cy.get('body > nav')
            .should('be.visible')
        cy.get('#navbarSupportedContent > ul > li > ul')
            .as('filterSelection')
            .should('not.be.visible')
        cy.get('#navbarDropdown')
            .should('be.visible')
            .click()
        cy.get('@filterSelection')
            .should('be.visible')
        cy.get('#navbarSupportedContent > div > a')
            .should('be.visible')
            .should('have.attr', 'href')
            .and('include', '/projectPage')
    })

    it('content container is available', () => {

        cy.get('#contentContainer')
            .should('be.visible')
    })

    it('footer is available', () => {

        cy.get('div.footer')
            .scrollIntoView()
            .should('be.visible')
    })
})
