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
})
