    async deleteIndexAsync() {
        console.log("\n Deleting existing index...");
        const endpoint = this.getIndexUrl();
        const response = await AzureSearchClient.request(endpoint, "DELETE", this.adminKey);
        AzureSearchClient.throwOnHttpError(response);
        return this;
    }
