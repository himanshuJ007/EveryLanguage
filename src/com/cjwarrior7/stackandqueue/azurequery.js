    async queryAsync(searchTerm) {
        console.log("\n Querying...")
        console.log("Search Term =",searchTerm);
        const endpoint = this.getSearchUrl(searchTerm);
        const response = await AzureSearchClient.request(endpoint, "GET", this.adminKey);
        AzureSearchClient.throwOnHttpError(response);
        return response;
    }
