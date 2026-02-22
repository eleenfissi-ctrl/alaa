const fp = require('fastify-plugin')

async function dbConnector(fastify) {
  const dbConfig = {
    promise: true,
    connectionString: process.env.DATABASE_URL || 
      `mysql://${process.env.DB_USER}:${process.env.DB_PASSWORD}@${process.env.DB_HOST}:${process.env.DB_PORT}/${process.env.DB_NAME}`
  }

  fastify.register(require('@fastify/mysql'), dbConfig)

  fastify.log.info('Database connector registered')
}

module.exports = fp(dbConnector)